public class SeqNumber {
    private int reader, writer, tokenMachine, readyToken;
    public synchronized void getReadLock() {
        int myToken = tokenMachine++; // get Seq Number
        // 若要 Writer 優先則 penddingWriter > 0
        while(writer > 0 || myToken > readyToken) {
            try{
                wait();
            } catch(Exception err) {

            }
        }
        reader++;
        readyToken++;
        notifyAll();
    }
    public synchronized void getWriteLock() {
        int myToken = tokenMachine++;
        // 若 Reader 優先
        while(writer > 0 || reader > 0 || myToken > readyToken) {
            try{
                wait();
            } catch(Exception err) {

            }
        }
        writer++;
        readyToken++;
    }
    public synchronized void releaseReadLock() {
        reader--;
        notifyAll();
    }
    public synchronized void releaseWriteLock() {
        writer--;
        notifyAll();
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