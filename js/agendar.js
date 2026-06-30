/* ---------------------------------------------------------------------------------------------- */
/*                                FUNCIONALIDAD AGENDAMIENTO                                       */
/* ---------------------------------------------------------------------------------------------- */

// Función para guardar los datos del formulario en el Local Storage
function guardarDatosEnLocalStorage(fecha, hora, terapeuta) {
    const cita = {
        fecha: fecha,
        hora: hora,
        terapeuta: terapeuta,
        estado: 'agendado'
    };

    // Obtener citas existentes del Local Storage
    let citasGuardadas = JSON.parse(localStorage.getItem('citas')) || [];

    // Agregar la nueva cita a la lista de citas
    citasGuardadas.push(cita);

    // Guardar la lista actualizada de citas en el Local Storage
    localStorage.setItem('citas', JSON.stringify(citasGuardadas));
}

// Función para mostrar el Sweet Alert con el mensaje de éxito
function mostrarSweetAlert() {
    Swal.fire({
        icon: 'success',
        title: 'Cita Agendada',
        text: 'La cita se ha agendado exitosamente.',
        confirmButtonText: 'Aceptar'
    });
}

// Función para mostrar el Sweet Alert con el mensaje de error
function mostrarErrorSweetAlert(mensaje) {
    Swal.fire({
        icon: 'error',
        title: 'Error',
        text: mensaje,
        confirmButtonText: 'Aceptar'
    });
}

// Evento para escuchar el envío del formulario
const formulario = document.getElementById('formularioAgendamiento');
formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    // Obtener los valores del formulario
    const fechaInput = document.getElementById('fecha');
    const fecha = fechaInput.value;
    const hora = document.getElementById('hora').value;
    const terapeutaSelect = document.getElementById('terapeuta');
    const terapeuta = terapeutaSelect.options[terapeutaSelect.selectedIndex].text;

    // Validar que la fecha no sea pasada (mínimo = hoy, normalizado a medianoche)
    const hoy = new Date();
    hoy.setHours(0, 0, 0, 0);
    const fechaSeleccionada = new Date(fecha);
    fechaSeleccionada.setHours(0, 0, 0, 0);

    if (fechaSeleccionada < hoy) {
        mostrarErrorSweetAlert('La fecha no puede ser anterior a hoy.');
        return; // Detener el proceso de envío del formulario
    }

    // Validar que todos los campos estén llenos
    if (fecha && hora && terapeuta) {
        // Guardar los datos del formulario en el Local Storage
        guardarDatosEnLocalStorage(fecha, hora, terapeuta);

        // Mostrar Sweet Alert con mensaje de éxito
        mostrarSweetAlert();

        // Limpiar el formulario después de enviarlo
        formulario.reset();
    } else {
        // Mostrar mensaje de error utilizando SweetAlert
        mostrarErrorSweetAlert('Por favor, complete todos los campos del formulario.');
    }
});
