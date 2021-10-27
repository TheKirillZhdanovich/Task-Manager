package com.zhdanovich.taskmanager.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "sequence_generator1", sequenceName = "sequence_generator1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator1")
    private Long id;
    private String challenge;

    public Task(String challenge) {
        this.challenge = challenge;
    }

}

