package model;

import model.exception_app.MyFileNotFoundException;
import model.exception_app.MyIOException;
import model.toy.Toy;
import model.toy.ToyList;

import java.io.*;

public class File_IO implements Serializable{

    String fileNameToy;
    String fileNameResult;
    public File_IO(){
        fileNameToy = new Config().getFileName();
        fileNameResult = new Config().getLotteryResult();
    }

    public boolean save(ToyList<Toy> toyList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileNameToy))){
            oos.writeObject(toyList);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Object load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileNameToy))){
            return ois.readObject();
        } catch (Exception e){
            return false;
        }
    }

    public void file_writer(String result_string){
         File myFile = new File(fileNameResult);
        try(FileOutputStream outputStream = new FileOutputStream(myFile, false)){
            byte[] buffer = result_string.getBytes();
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException(fileNameResult, e.fillInStackTrace().toString());
        } catch (IOException e) {
            throw new MyIOException(fileNameResult, e.fillInStackTrace().toString());
        }
    }

}
