package com.example.project;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 15:38
 */

@Tag("timed")
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger {
}
