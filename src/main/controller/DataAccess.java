package main.controller;

/**
 * Created by daniel.ye on 08/03/17.
 */
public class DataAccess {

    private DataWriter writer;
    private DataReader reader;

    public DataAccess(DataWriter writer, DataReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void println(String message) {
        writer.println(message);
    }

    public void close(){
        writer.close();
    }

    public String readln(){
        return reader.readln();
    }

    public boolean hasNext(){
        return reader.hasNext();
    }
}
