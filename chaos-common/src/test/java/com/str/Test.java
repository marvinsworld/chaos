package com.str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewan on 17/9/14.
 */
public class Test {

    public static void main(String[] args) {

        List<CommentLabel> comment_labels = new ArrayList<CommentLabel>();

        CommentLabel commentLabel = new CommentLabel();
        commentLabel.setContent("11");
        commentLabel.setLabel_type(1);

        comment_labels.add(commentLabel);

        List<String> labels = new ArrayList<String>();
        for (CommentLabel label:comment_labels) {

            labels.add(label.getContent());
        }

        String aa  = JacksonUtil.toJson(labels);
        System.out.println(aa);
    }
}
