from flask import Blueprint, abort, request, render_template, redirect
import requests # type: ignore
router = Blueprint ('router', __name__)

@router.route('/')
def home():
    
    return render_template('fragmento/inicial/login.html')


##-----Ruta para acceder a los proyectos 
@router.route('/admin/proyectos/list')
def mt_proyectos():
    r = requests.get('http://localhost:8088/myapp/proyectos/infoproyectos')
    #print(type(r.json()))
    #print(r.json())
    data = r.json()
    return render_template('fragmento/persona/lista.html', lista = data ["data"])