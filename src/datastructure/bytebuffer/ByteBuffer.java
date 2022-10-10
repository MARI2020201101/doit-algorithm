package datastructure.bytebuffer;

class ByteBuffer {
    int available = 0;
    int capacity= 0;
    int writePointer = 0;
    int readPointer = 0;
    byte[] buffer;

    public ByteBuffer(int capacity){
        this.buffer = new byte[capacity];
        this.capacity = capacity;
        this.available = capacity;
    }

    public boolean put(int value){
        if(available>=capacity) return false;
        buffer[writePointer] = (byte) value;
        writePointer = (writePointer+1)%capacity;
        available++;
        return true;
    }
    public byte get(){
        if(available<=0) return -1;
        byte value = buffer[readPointer];
        readPointer = (readPointer+1)%capacity;
        available--;
        return value;
    }
    public int copy(byte[] dest, int offset, int len) {
        if(available <=0) return -1;

        int maxPointer = capacity;
        if(readPointer < writePointer) maxPointer = writePointer;
        int countBytes = Math.min(maxPointer - readPointer, len);
        System.arraycopy(buffer, readPointer, dest, offset, countBytes);
        readPointer = readPointer + countBytes;

        if(readPointer == capacity){
            int remainingBytes = Math.min(len-countBytes, writePointer);
            if(remainingBytes > 0){
                System.arraycopy(buffer, 0, dest, offset+countBytes, remainingBytes);
                readPointer = remainingBytes;
                countBytes = countBytes + remainingBytes;
            }else{
                readPointer = 0;
            }
        }
        available = available - countBytes;
        return countBytes;
    }

}
