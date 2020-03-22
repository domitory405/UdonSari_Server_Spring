package kr.domi.udonsari.model;

import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class DefaultRes<T> {
    private int status;
    private String message;
    private int len;
    private T data;

    public static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);

    public DefaultRes(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public DefaultRes(int status, String message, int len) {
        this.status = status;
        this.message = message;
        this.len = len;
        this.data = null;
    }

    public static <T> DefaultRes<T> res(final int status, final String message) {
        return res(status, message, null);
    }

    public static <T> DefaultRes<T> res(final int status, final String message, final T t) {
        return DefaultRes.<T>builder()
                .data(t)
                .status(status)
                .message(message)
                .build();
    }

    public static <T> DefaultRes<T> res(final int status, final String message, final T t, final int len) {
        return DefaultRes.<T>builder()
                .data(t)
                .status(status)
                .message(message)
                .len(len)
                .build();
    }
}
