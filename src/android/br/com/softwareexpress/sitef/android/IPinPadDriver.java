package br.com.softwareexpress.sitef.android;

interface IPinPadDriver {
    boolean start();

    void terminate();

    void flush();

    int write(byte[] var1, int var2);

    int read(byte[] var1, int var2, int var3);
}