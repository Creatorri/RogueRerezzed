
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Torri
 */
public class RogueProperties {
    private File rp;
    private Properties p;
    private String[] props;
    private String[] out;
    /**
     * Creates properties file
     * @param dir
     * @param props 
     */
    public RogueProperties(String dir,String[] props){
        rp=new File(dir);
        this.props=props;
        out = new String[props.length];
        try {
            rp.createNewFile();
            try (FileInputStream inStream = new FileInputStream(rp)) {
                p = new Properties();
                p.load(inStream);
                for (String prop : props) {
                    if (p.getProperty(prop) == null) {
                        p.setProperty(prop, "0");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    /**
     * Creates Properties File
     * @param dir
     * @param props
     * @param data 
     */
    public RogueProperties(String dir,String[] props,String[] data){
        rp=new File(dir);
        this.props=props;
        out = new String[props.length];
        try {
            rp.createNewFile();
            try (FileInputStream inStream = new FileInputStream(rp)) {
                p = new Properties();
                p.load(inStream);
                for (String prop : props) {
                    if (p.getProperty(prop) == null) {
                        p.setProperty(prop, "0");
                    }
                }
            }
            save();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    /**
     * Adds data
     * @param prop
     * @param setting 
     */
    public void addData(String prop,String setting){
        try {
            try (FileInputStream inStream = new FileInputStream(rp)) {
                p = new Properties();
                p.load(inStream);
                p.setProperty(prop,setting);
            }
            save();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    /**
     * Adds Data
     * @param propnum
     * @param setting 
     */
    public void setData(int propnum,String setting){
        try {
            try (FileInputStream inStream = new FileInputStream(rp)) {
                p = new Properties();
                p.load(inStream);
                p.setProperty(props[propnum],setting);
            }
            save();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    /**
     * Adds Data
     * @param setting 
     */
    public void setData(String[] setting){
        try {
            try (FileInputStream inStream = new FileInputStream(rp)) {
                p = new Properties();
                p.load(inStream);
                for(int i=0;i<setting.length;i++){
                    p.setProperty(props[i],setting[i]);
                }
            }
            save();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    /**
     * gets data
     * @return 
     */
    public String[] getSettings(){
        try(FileInputStream inStream = new FileInputStream(rp)){
            p = new Properties();
            p.load(inStream);
            for(int i=0;i<props.length;i++){
                if (p.getProperty(props[i]) == null) {
                    p.setProperty(props[i], "0");
                }
                out[i]=p.getProperty(props[i]);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return out;
    }
    /**
     * saves file
     */
    private void save(){
        try {
            try (FileOutputStream out = new FileOutputStream(rp)) {
                p.store(out,"Properties settings");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}