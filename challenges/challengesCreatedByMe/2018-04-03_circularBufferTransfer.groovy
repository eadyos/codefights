/*
https://app.codesignal.com/challenge/yAWa8u9FWBiHKBGxA

A circular buffer can be used to bridge data transfer between a producer and consumer system.

Given an amount of data, how long will it take to transfer that data from the producer system to the consumer system through the circularBuffer.

The producer and consumer may write to and read from the buffer at different rates.

The producer system will try writing to the circularBuffer only in increments of size maxWrite unless the data left to be transferred is less than that.

It always takes the producer system an amount of time writeTime to write any data to the circular buffer.

The consumer system will (greedily) try reading from the circular buffer in increments up to size readMax.

It always takes the consumer system an amount of time readTime to read any data from the buffer.

The producer and consumer can read-to and write-from the circular buffer at the same time, but not on the same data. In other words, while the producer is writing to the buffer, that data is blocked from reading, but the consumer is free to read from a previously written block of data.

Conversely, the producer cannot write to data that is currently being read.

Example

For data = 20, buffer = 20, maxWrite = 10, writeTime = 1, consumerBuffer = 10 and readTime = 1, the output should be
circularBufferTransfer(data, buffer, maxWrite, writeTime, maxRead, readTime) = 3.

At 0 milliseconds...
The circularBuffer is empty.
The producer can begin writing 10 bytes of data to the 20 byte buffer.

At 1 millisecond...
The writeTime is 1ms so the producer has finished writing to the circularBuffer.
The circularBuffer has free space, so the producer can begin writing another chunk.
The consumer can begin reading from the circularBuffer.

At 2 milliseconds...
The producer has finished writing the second chunk of data.
The consumer has finished reading the first chunk of data because the readTime is 1ms.
The consumer begins reading the second chunk of data.

At 3 milliseconds...
The consumer finishes reading the second chunk of data.

The transfer took 3 milliseconds.

For data = 35, buffer = 20, maxWrite = 15, writeTime = 1, maxRead = 20, readTime = 1, the output should be
circularBufferTransfer(data, buffer, maxWrite, writeTime, maxRead, readTime) = 5.

At 0 milliseconds...
The circularBuffer is empty.
The producer can begin writing 15 bytes of data to the 20 byte buffer.

At 1 millisecond...
The writeTime is 1ms so the producer has finished writing to the circularBuffer.
The circularBuffer has some free space, but the producer is patient and will not begin writing until there is 15 bytes of free space, or there is less than 15 bytes remaining to be transferred.
The consumer can begin reading from the circularBuffer. The consumer can read 20 bytes of data at a time but the consumer is greedy. It will read any amount of data, so it begins reading 15 bytes.

At 2 milliseconds...
The consumer has finished reading the first chunk of 15 bytes because the readTime is 1ms.
The producer begins writing the second chunk of 15 bytes because there is now enough free space to do so.
The consumer has nothing to read.

At 3 milliseconds...
The producer finishes writing the second chunk of 15 bytes.
The consumer can begin reading the second chunk of 15 bytes.
The producer only has 5 bytes remaining to transfer.
There are 5 bytes of free space in the circular buffer.
The producer begins writing 5 bytes into the circular buffer.

At 4 milliseconds...
The consumer has finished reading the second chunk of 15 bytes.
The producer finishes writing the last chunk of 5 bytes to the circular buffer.
The consumer can begin reading the last 5 bytes of data.

At 5 milliseconds...
The consumer finishes reading the last 5 bytes.

The transfer took 5 ms.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer data

Size of the total input (in bytes).

Guaranteed constraints:
0 ≤ data ≤ 200000.

[input] integer buffer

Size of the circular buffer (in bytes).

Guaranteed constraints:
0 < buffer ≤ 200000.

[input] integer maxWrite

The amount of data the producer tries to write to the circularBuffer at once. The producer will always wait and try to write the maximum amount of data, unless the data remaining to be transferred is less than this amount.

Guaranteed constraints:
0 < maxWrite ≤ 200000.

[input] integer writeTime

The length of time (in milliseconds) it takes to write any data from the producer to the circularBuffer.

Guaranteed constraints:
0 < writeTime ≤ 1000.

[input] integer maxRead

The amount of data the consumer tries to read from the circularBuffer at once. The consumer will read any amount of data up to this amount if it is available.

Guaranteed constraints:
0 < maxRead ≤ 200000.

[input] integer readTime

The length of time (in milliseconds) it takes to read any data from the circularBuffer.

Guaranteed constraints:
0 < readTime ≤ 1000.

[output] integer

The number of milliseconds it takes to transfer all of the data through the circular buffer.
*/

int circularBufferTransfer(int data, int circularBuffer, int writeMax, int writeTime, int readMax, int readTime) {
  
    def totalToSend = data
    def bufferCurrent = 0
    def totalOutput = 0
    def cycle = 0

    def inputStarted = -1
    def outputStarted = -1
    def outputToTransfer = 0

    if(writeMax > circularBuffer){
        writeMax = circularBuffer
    }

    while(totalOutput < data){
        if(inputStarted >= 0 && inputStarted + writeTime == cycle){
            def totalSent = totalToSend > writeMax ? writeMax : totalToSend
            bufferCurrent += totalSent
            totalToSend -= totalSent
            inputStarted = -1
//            println "$cycle: write ended"
        }
        if(outputStarted >= 0 && outputStarted + readTime == cycle){
            totalOutput += outputToTransfer
            bufferCurrent -= outputToTransfer
            outputStarted = -1
//            println "$cycle: read ended"
        }
        if(bufferCurrent + [writeMax, totalToSend].min() <= circularBuffer && inputStarted < 0 && totalToSend > 0){
//            println "$cycle: write started"
            inputStarted=cycle
        }
        if(bufferCurrent > 0 && outputStarted < 0){
//            println "$cycle: read started"
            outputToTransfer = [bufferCurrent, readMax].min()
            outputStarted=cycle
        }
        if(totalOutput < data){
            cycle++
        }
    }
//    println cycle
    return cycle
    
}
