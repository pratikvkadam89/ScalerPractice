package com.lld2.Singleton.Assignment3;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPoolImpl implements ConnectionPool {

    private static ConnectionPoolImpl instance;

    private LinkedList<DatabaseConnection> availablePool;
    private int maxPoolSize;
    private static Lock lock = new ReentrantLock();

    private ConnectionPoolImpl(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.availablePool = new LinkedList<>();
        this.initializePool();
    }

    public static ConnectionPool getInstance(int maxConnections) {

        if(instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new ConnectionPoolImpl(maxConnections);
            }
            lock.unlock();
        }

        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public void initializePool() {
        for (int i = 1; i <= maxPoolSize; i++) {
            this.availablePool.add(new DatabaseConnection(i));
        }

    }

    @Override
    public DatabaseConnection getConnection() {
        return this.availablePool.poll();
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        this.availablePool.add(connection);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return this.availablePool.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.maxPoolSize;
    }
}
