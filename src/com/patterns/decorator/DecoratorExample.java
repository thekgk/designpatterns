package com.patterns.decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        DecoratorExample d = new DecoratorExample();
        Notifier n = d.getNotifier(true, true);
        n.sendMessage();
    }

    private Notifier getNotifier(boolean sendSMS, boolean sendToFB){
        Notifier notifier = new DefaultNotifier("hello world");
        if(sendSMS) {
            notifier = new SMSNotifier(notifier);
        }
        if(sendToFB){
            notifier = new FacebookNotifier(notifier);
        }
        return notifier;
    }

    public interface Notifier{
        void sendMessage();
        String getMessage();
    }

    public class DefaultNotifier implements Notifier{
        private String message;

        public DefaultNotifier(String message){
            this.message = message;
        }

        public String getMessage(){
            return this.message;
        }

        public void sendMessage() {
            System.out.println("Sending via Email (Default): " + this.message);
        }
    }

    public abstract class NotificationDecorator implements Notifier{
        private Notifier wrappedInstance;

        public NotificationDecorator(Notifier n){
            this.wrappedInstance = n;
        }

        public String getMessage(){
            return wrappedInstance.getMessage();
        }
        @Override
        public void sendMessage(){
            wrappedInstance.sendMessage();
        }
    }

    public class SMSNotifier extends NotificationDecorator{
        public SMSNotifier(Notifier n) {
            super(n);
        }

        @Override
        public void sendMessage() {
            System.out.println("Sending via SMS: " + super.getMessage());
            super.sendMessage();
        }
    }

    public class FacebookNotifier extends NotificationDecorator{
        public FacebookNotifier(Notifier n) {
            super(n);
        }

        @Override
        public void sendMessage() {
            System.out.println("Sending via Facebook: " + super.getMessage());
            super.sendMessage();
        }
    }
}
