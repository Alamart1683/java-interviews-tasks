package task2;

public class OrderService {
    enum Type {DELIVERY, PICKUP}

    static class OrderData {
        final Type type;
        final String currency;
        final Long amount;

        OrderData (Type type,
                   String currency,
                   Long amount) {
            this.type = type;
            this.currency = currency;
            this.amount = amount;
        }

        String getCurrency() {
            return currency;
        }

        Long getAmount() {
            return amount;
        }

        Type getType() {
            return type;
        }
    }
}

