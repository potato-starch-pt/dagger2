package com.example.catfacts.data.mapper

import com.example.catfacts.data.remote.dto.FactDto
import com.example.catfacts.domain.model.Fact

fun FactDto.toFact(): Fact = Fact(
    text = fact,
    length = length
)