package com.example.Client.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ImageWorker extends Remote {
    byte[] filter(byte[] byteOfImage) throws RemoteException;
}
