:- dynamic(enfermedad/4).

coincide_sintomas(Enfermedad, []).
coincide_sintomas(NombreE, [PSintoma | RestoSintomas]):-
    enfermedad(NombreE, sintomas(ListaSE), _, _),
    buscar(PSintoma,ListaSE),
    coincide_sintomas(NombreE,RestoSintomas).

buscar(Elemento, [Elemento | _]).
buscar(Elemento, [_ | RestoLista]):-
    buscar(Elemento, RestoLista).

diagnostico(ListaSP, NombreE):-
    enfermedad(NombreE, sintomas(ListaSE), _, _),
    obtenersintoma(ListaSP, Sintoma),
    buscar(Sintoma, ListaSE).

obtenersintoma([PSintoma | _], PSintoma).
obtenersintoma([_ | RestoSintomas], Sintoma):-
    obtenersintoma(RestoSintomas, Sintoma).

diagnostico_categoria(Categoria, NombreE):-
    enfermedad(NombreE, _, categoria(CategoriaE), _),
    Categoria = CategoriaE.

recomendacion(NombreE, ListaRec) :-
    enfermedad(NombreE, _, _, recomendaciones(ListaRec)).

enfermedades_cronicas(NombreE):-
    enfermedad(NombreE, _, categoria(cronica), _).

enfermedades_por_sintoma(Sintoma, NombreE) :-
    enfermedad(NombreE, sintomas(ListaS), _, _),
    buscar(Sintoma, ListaS).