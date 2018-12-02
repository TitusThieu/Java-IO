package com.fa.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
	public static final String FILE_STUDENT= "student.txt";

	/**
	 * @param fileName: name directory of file
	 * @return true if file existed and have data else return false
	 */
	public static boolean checkData(String fileName) {
		File file = new File(fileName);
		return file.length() > 0 && file.exists();
	}

	/**
	 * @param fileName
	 * @return object which read from file
	 */
	public static Object readFile(String fileName) {
		Object object = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			fin = new FileInputStream(fileName);
			ois = new ObjectInputStream(fin);
			object = ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return object;
	}

	/**
	 * @param object:
	 * write a object into file
	 */
	public static void writeFile(Object object,String fileName) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			System.out.println("Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
