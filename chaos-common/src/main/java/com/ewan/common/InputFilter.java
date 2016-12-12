package com.ewan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:输入过滤
 * rom url:http://www.pigg.co/emoji-filter.html/comment-page-1
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/12/10 10:54
 */
public class InputFilter {

    /**
     * emoji表情过滤
     *
     * 目前不能使用,待研究
     */
    public static String filterEmoji(CharSequence source) {
        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        Matcher emojiMatcher = emoji.matcher(source);
        if (emojiMatcher.find()) {
            return "";
        }

        return null;
    }
}
