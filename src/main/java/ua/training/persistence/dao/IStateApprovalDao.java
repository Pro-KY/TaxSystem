package ua.training.persistence.dao;

import ua.training.persistence.entities.StateApproval;

import java.util.Optional;

public interface IStateApprovalDao extends IDao<StateApproval> {
    Optional<StateApproval> findByState(String state);
}
