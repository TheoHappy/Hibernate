package Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This is User class <br>
 * <b>It is a model for user </b> <br>
 * Info about entity <a>https://www.objectdb.com/java/jpa/start/entity</a><br>
 * @author Theo
 * @version  1.1
 * @since 1.0

 * */
@Entity
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "user_name")
    private String userName;

}
