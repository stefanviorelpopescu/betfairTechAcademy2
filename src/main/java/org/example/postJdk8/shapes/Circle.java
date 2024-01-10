package org.example.postJdk8.shapes;

import lombok.Data;

@Data
public sealed class Circle implements Shape permits FilledCircle {

        int radius;
}
