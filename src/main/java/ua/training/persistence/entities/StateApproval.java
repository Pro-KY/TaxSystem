package ua.training.persistence.entities;


import java.io.Serializable;
import java.util.Objects;

public class StateApproval implements Serializable {

  private Long id;
  private String state;

  public StateApproval(Long id, String state) {
    this.id = id;
    this.state = state;
  }

  public StateApproval(Long id) {
    this.id = id;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "StateApprovalEnum{" +
            "id=" + id +
            ", state='" + state + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StateApproval that = (StateApproval) o;
    return id == that.id &&
            Objects.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, state);
  }
}
