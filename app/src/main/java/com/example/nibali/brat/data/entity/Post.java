package com.example.nibali.brat.data.entity;

import android.os.Build;
import android.support.annotation.RequiresApi;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Post {
    private int id;
    private Owner owner;
    private LocalDateTime date;
    private String text;
    private int reposts;
    private int likes;
    private List<? extends Attachment> attachments;

    public Post(int id, Owner owner, LocalDateTime date, String text, int reposts, int likes, List<? extends Attachment> attachments) {
        this.id = id;
        this.owner = owner;
        this.date = date;
        this.text = text;
        this.reposts = reposts;
        this.likes = likes;
        this.attachments = attachments;
    }

//    @BindingAdapter({"app:imageUrl"})
//    public static void loadImage(ImageView view, String imageUrl) {
//        Picasso.get().load(imageUrl).into(view);
//        view.setVisibility(imageUrl != null ? View.VISIBLE : View.GONE);
//    }
//
//    @BindingAdapter("android:longText")
//    public static void setLongText(TextView view, long number) {
//        view.setText(String.valueOf(number));
//    }
//
//    @BindingAdapter("android:datetime")
//    public static void setLongText(TextView view, Date date) {
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String dateString = simpleDateFormat.format(date);
//        view.setText(dateString);
//    }
//
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    public String getMainPhoto(){
        if(attachments != null && !attachments.isEmpty()){
            Optional<? extends Attachment> attachment = attachments.stream()
                    .filter(a -> ((Attachment) a).getType() == AttachmentType.PHOTO)
                    .findFirst();
            return attachment.map(attachment1 -> ((Photo) attachment1).getPhoto_604()).orElse(null);
        }
        return null;
    }
}
