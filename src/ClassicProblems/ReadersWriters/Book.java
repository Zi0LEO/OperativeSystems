package ClassicProblems.ReadersWriters;

public abstract class Book {

    public abstract void startWriting() throws InterruptedException;

    public abstract void stopWriting() throws InterruptedException;

    public abstract void startReading() throws InterruptedException;

    public abstract void stopReading() throws InterruptedException;

    public void test(int numWriters, int numReaders){
        Reader[] readers = new Reader[numReaders];
        for(int i = 0; i < numReaders; i++)
            readers[i] = new Reader(this);

        Writer[] writers = new Writer[numWriters];
        for(int i = 0; i < numWriters; i++)
            writers[i] = new Writer(this);

        for(Writer writer: writers)
            new Thread(writer).start();

        for(Reader reader: readers)
            new Thread(reader).start();
    }
}
