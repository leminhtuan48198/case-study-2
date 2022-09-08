package model;

import java.io.Serializable;
import java.time.LocalDate;

public interface ExpiredDate extends Serializable {
    LocalDate getExpiredDate();
}
