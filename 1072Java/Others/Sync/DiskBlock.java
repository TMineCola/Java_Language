public class DiskBlock {
    private int reader, writer, penddingReader, penddingWriter;
    private long currentTokenNum, lastReaderToken, lastWriterToken;
    public synchronized void getReadLock() {
        penddingReader++;
        // 若要 Writer 優先則 penddingWriter > 0
        while(writer > 0) {
            try{
                wait();
            } catch(Exception err) {

            }
        }
        penddingReader--;
        reader++;
    }
    public synchronized void getWriteLock() {
        penddingWriter++;
        // 若 Reader 優先
        while(writer > 0 || reader > 0 || penddingReader > 0) {
            try{
                wait();
            } catch(Exception err) {

            }
        }
        penddingWriter--;
        writer++;
    }
    public synchronized void releaseReadLock() {

    }
    public synchronized void releaseWriteLock() {

    }
    public void read() {
        getReadLock();
        // Read
        releaseReadLock();
    }
    public void write() {
        getWriteLock();
        // Write
        releaseWriteLock();
    }
    public static void main(String[] args) {
        
    }
}