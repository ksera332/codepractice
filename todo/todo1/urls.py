from django.conf.urls import url,include
from .views import TodoList,TodoDetail,TodoCreate,TodoDelete,TodoUpdate

urlpatterns = [
    url(r'^list/',TodoList.as_view(),name = "list"),
    url(r"^detail/<int:pk>",TodoDetail.as_view(),name = "detail"),
    url(r'^create/',TodoCreate.as_view(),name = "create"),
    url(r'^delete/<int:pk>',TodoDelete.as_view(),name="delete"),
    url(r'^update/<int:pk>',TodoUpdate.as_view(),name="update"),
]
