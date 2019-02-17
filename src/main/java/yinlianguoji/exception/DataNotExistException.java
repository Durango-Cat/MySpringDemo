package main.java.yinlianguoji.exception;

/**
 * @author ZhuQiuPing
 *         on 2018/10/29
 */
public class DataNotExistException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3841523542987793552L;

    public DataNotExistException() {
        super();
    }

    public DataNotExistException(String msg) {
        super(msg);
    }

    public DataNotExistException(Exception ex) {
        super(ex);
    }

    public DataNotExistException(String msg, Exception ex) {
        super(msg, ex);
    }
}

