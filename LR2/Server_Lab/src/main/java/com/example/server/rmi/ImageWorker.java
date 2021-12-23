package com.example.server.rmi;

import java.rmi.RemoteException;

public interface ImageWorker
{
    byte[] filter(byte[] byteOfImage) throws RemoteException;
}
