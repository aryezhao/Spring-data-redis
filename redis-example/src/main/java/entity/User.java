package entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by lenovo on 2019/8/7.
 */
public class User implements Serializable{

    private Integer id;
    private String name;
    private String pwd;
    private String image;
    private MultipartFile file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", image='" + image + '\'' +
                ", file=" + file +
                '}';
    }
}
