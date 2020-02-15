/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

/**
 *
 * @author Lenovo
 */
public class Shaper {

    Shaper() throws FileNotFoundException {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "Group.txt")));
            int number = (int) (Math.random() * 50);;
            for (int i = 0; i < number - 1; i++) {
                int amount = 1 + (int) (Math.random() * 5);//количество человек в группе
                int table = 5 + (int) (Math.random() * 6);//время за столом 
                int queue = 3 + (int) (Math.random() * 3);//время в очереди
                out.write(amount + " " + table + " " + queue);
                out.newLine();
            }
            int amount = 1 + (int) (Math.random() * 5);//количество человек в группе
            int table = 5 + (int) (Math.random() * 6);//время за столом 
            int queue = 3 + (int) (Math.random() * 3);//время в очереди
            out.write(amount + " " + table + " " + queue);
            out.close();
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }
    }
}
