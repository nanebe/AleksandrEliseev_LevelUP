package homework_2.task_1;

enum Operations {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    EXPONENTIATION("^"),
    FACTORIAL("fact"),
    FIBONACCI("fibo");

    private final String sign;

    @Override
    public String toString() {
        return sign;
    }

    Operations(String sign) {
        this.sign = sign;
    }

    public static Operations getOperationBySign(String sign) {
        for (Operations operation : values()) {
            if (operation.sign.equals(sign)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No operation found with sign: [" + sign + "]");
    }
    public static String toStringAllOperationSigns() {
        StringBuilder sb = new StringBuilder();
        for (Operations operation : values()) {
            sb.append(operation.sign + " ");
        }
        return sb.toString().strip();
    }
}
