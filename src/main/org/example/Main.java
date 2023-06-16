package main.org.example;

public class Main {

    static public void main(String[] args) {
        if (args.length < 2) {
            System.err.println("not enough arguments");
            return;
        }
        if (args.length > 2) {
            System.err.println("too many arguments");
            return;
        }
        Downloader downloader = new Downloader();
        String path = args[0];
        String signature = args[1];
        String body = downloader.find(path, signature);
        if (body == null) {
            System.err.println("can't find method in file");
        } else if (body.equals("can't find file")) {
            System.err.println("can't find file");
        } else {
            System.out.println(body);
        }
    }
}
