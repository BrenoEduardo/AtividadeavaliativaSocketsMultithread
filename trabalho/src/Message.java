public class Message {
    private String messageType;
    private String transactionValue;
    private String localTransactionTime;
    private String transactionDate;
    private String transmissionNetwork;
    private String cardNumber;
    private String paymentMethod;

    public Message(String messageType, String transactionValue, String localTransactionTime, String transactionDate, String transmissionNetwork, String cardNumber, String paymentMethod) {
        this.messageType = messageType;
        this.transactionValue = transactionValue;
        this.localTransactionTime = localTransactionTime;
        this.transactionDate = transactionDate;
        this.transmissionNetwork = transmissionNetwork;
        this.cardNumber = cardNumber;
        this.paymentMethod = paymentMethod;
    }

    public String buildMessage() {
        String messageBody = messageType +
                transactionValue +
                localTransactionTime +
                transactionDate +
                transmissionNetwork +
                cardNumber +
                paymentMethod;
        return messageBody;
    }
}