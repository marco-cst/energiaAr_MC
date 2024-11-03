from flask import Blueprint, abort, request, render_template, redirect
import requests # type: ignore
router = Blueprint ('router', __name__)

@router.route('/')
def home():
    
    return render_template('fragmento/inicial/login.html')

#-----Ruta para acceder a los proyectos 
@router.route('/admin/proyectos/list')
def mt_proyectos():
    r = requests.get('http://localhost:8088/myapp/proyectos/infoproyectos')
    #print(type(r.json()))
    #print(r.json())
    data = r.json()
    return render_template('fragmento/persona/lista.html', lista = data ["data"])

##-----Ruta para acceder a los inversionistas
@router.route('/admin/inversionista/lista')
def mt_inversionistas():
    r = requests.get('http://localhost:8088/myapp/proyectos/inversionistas')
    data = r.json()
    
    inversionistas_list = extract_inversionistas(data["data"])
    
    print("Inversionistas List:", inversionistas_list)
    
    return render_template('fragmento/persona/inversionistas.html', lista=inversionistas_list)

#--extraer los ivnersionistas de la lista
def extract_inversionistas(data):
    inversionistas = []
    current = data.get('header')
    while current:
        inversionistas.append(current['info'])
        current = current.get('next')
    return inversionistas