package org.readcom.util;

/**
 * @program: box-system
 * @description: UUID唯一标识符生成类
 * @author: zhangxiaoyu
 * @create: 2025-04-21 17:00
 **/
public class Uuid {
    private static final long START_TIMESTAMP = 1700000000000L;
    private static final long SEQUENCE_BITS = 12;
    private static final long MACHINE_BITS = 10;
    private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    private static final long MACHINE_LEFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_LEFT = SEQUENCE_BITS + MACHINE_BITS;

    private static long machineId;
    private static long sequence = 0L;
    private static long lastTimestamp = -1L;


    public static void init(long mId) {
        if (mId > MAX_MACHINE_NUM || mId < 0) {
            throw new IllegalArgumentException("机器ID超出范围");
        }
        machineId = mId;
    }


    public static synchronized long nextId() {
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("系统时钟回拨了");
        }
        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                currentTimestamp = waitNextMillis();
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = currentTimestamp;
        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT)
                | (machineId << MACHINE_LEFT)
                | sequence;
    }

    private static long waitNextMillis() {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

}
