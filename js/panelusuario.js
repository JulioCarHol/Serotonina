/* ---------------------------------------------------------------------------------------------- */
/*                          FUNCIONALIDAD PARA PERFIL EN PANEL DE USUARIO                         */
/* ---------------------------------------------------------------------------------------------- */

document.addEventListener('DOMContentLoaded', function () {
    // Obtener los valores almacenados en el Local Storage (null-safe)
    const name = localStorage.getItem('Name') || '';
    const email = localStorage.getItem('Email') || '';
    const num = localStorage.getItem('Num') || '';

    // Mostrar los valores almacenados en la sección "Perfil"
    const nameElement = document.querySelector('#name-li');
    const emailElement = document.querySelector('#email-li');
    const numElement = document.querySelector('#num-li');

    if (nameElement) nameElement.textContent += name;
    if (emailElement) emailElement.textContent += email;
    if (numElement) numElement.textContent += num;

    // Obtener las citas almacenadas en el Local Storage (try/catch ante JSON malformado)
    let citasGuardadas = [];
    try {
        citasGuardadas = JSON.parse(localStorage.getItem('citas')) || [];
    } catch (e) {
        citasGuardadas = [];
    }

    // Mostrar las citas en la sección "Citas"
    const citasList = document.querySelector('#citas-list');
    if (citasList && Array.isArray(citasGuardadas)) {
        citasGuardadas.forEach((cita) => {
            const citaItem = document.createElement('li');
            const fecha = cita?.fecha ?? '-';
            const hora = cita?.hora ?? '-';
            const terapeuta = cita?.terapeuta ?? '-';
            const estado = cita?.estado ?? '-';
            citaItem.textContent = `${fecha} - ${hora}, Terapeuta: ${terapeuta}, Estado: ${estado}`;
            citasList.appendChild(citaItem);
        });
    }
});
