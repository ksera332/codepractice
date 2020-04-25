# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.db import models

# Create your models here.

PRIORITY = (("danger","High"),("info","Normal"),("success","Low"))

class TodoModel(models.Model):
    title = models.CharField(max_length = 100)
    memo = models.TextField()
    priority = models.CharField(
        max_length = 50,
        choices = PRIORITY 
    )
    duedate = models.DateField()

    def __str__(self):
        return self.title