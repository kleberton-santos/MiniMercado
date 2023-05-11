package Exception;

public class DbException extends RuntimeException {

    public DbException(String msg){
        super(msg);
    }
}