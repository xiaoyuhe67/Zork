class MyAppException extends Exception {
 
    private String message = null;
 
    public MyAppException() {
        super();
    }
 
    public MyAppException(String message) {
        super(message);
        this.message = message;
    }
 
    public MyAppException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
