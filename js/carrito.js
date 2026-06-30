/* ---------------------------------------------------------------------------------------------- */
/*                                FUNCIONALIDAD CARRITO DE COMPRAS                                */
/* ---------------------------------------------------------------------------------------------- */

// Esperamos que todos los elementos de la página carguen para ejecutar el script
if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready();
}

function ready() {
    // Cargamos los elementos del carrito del Local Storage al cargar la página
    cargarCarritoDesdeLocalStorage();

    // Agregamos funcionalidad a los botones eliminar del carrito ya existentes
    let botonesEliminarItem = document.getElementsByClassName('btn-eliminar');
    for (let i = 0; i < botonesEliminarItem.length; i++) {
        botonesEliminarItem[i].addEventListener('click', eliminarItemCarrito);
    }

    // Agregamos funcionalidad al botón sumar cantidad
    let botonesSumarCantidad = document.getElementsByClassName('sumar-cantidad');
    for (let i = 0; i < botonesSumarCantidad.length; i++) {
        botonesSumarCantidad[i].addEventListener('click', sumarCantidad);
    }

    // Agregamos funcionalidad al botón restar cantidad
    let botonesRestarCantidad = document.getElementsByClassName('restar-cantidad');
    for (let i = 0; i < botonesRestarCantidad.length; i++) {
        botonesRestarCantidad[i].addEventListener('click', restarCantidad);
    }

    // Agregamos funcionalidad al botón Agregar al carrito
    let botonesAgregarAlCarrito = document.getElementsByClassName('boton-item');
    for (let i = 0; i < botonesAgregarAlCarrito.length; i++) {
        botonesAgregarAlCarrito[i].addEventListener('click', agregarAlCarritoClicked);
    }

    // Agregamos funcionalidad al botón pagar
    document.getElementsByClassName('btn-pagar')[0].addEventListener('click', pagarClicked);

    // Sincronizamos el estado visual de los botones de producto con el carrito cargado
    actualizarEstadoBotonesProductos();
}

function cargarCarritoDesdeLocalStorage() {
    let carrito = JSON.parse(localStorage.getItem('carrito'));
    if (carrito) {
        carrito.forEach(item => {
            agregarItemAlCarrito(item.titulo, item.precio, item.imagenSrc, item.esServicio, false);
        });
    }
}

// Función para guardar el carrito en el Local Storage
function guardarCarritoEnLocalStorage() {
    let carritoItems = document.getElementsByClassName('carrito-item');

    let carrito = [];
    for (let i = 0; i < carritoItems.length; i++) {
        let item = carritoItems[i];
        let titulo = item.getElementsByClassName('carrito-item-titulo')[0].innerText;
        let precio = item.getElementsByClassName('carrito-item-precio')[0].innerText;
        let imagenSrc = item.getElementsByTagName('img')[0].src;
        let esServicio = item.getAttribute('data-es-servicio') === "true";

        carrito.push({ titulo, precio, imagenSrc, esServicio });
    }

    localStorage.setItem('carrito', JSON.stringify(carrito));
}

// Vaciamos el carrito tras pagar
function pagarClicked() {
    Swal.fire({
        title: "Gracias por la compra",
        icon: "success",
        confirmButtonText: "Aceptar"
    });

    let carritoItems = document.getElementsByClassName('carrito-items')[0];
    while (carritoItems.hasChildNodes()) {
        carritoItems.removeChild(carritoItems.firstChild);
    }

    actualizarTotalCarrito();
    actualizarEstadoBotonesProductos();
    guardarCarritoEnLocalStorage();

    setTimeout(function () {
        window.location.href = "agendar.html";
    }, 2000);
}

function agregarAlCarritoClicked(event) {
    let button = event.target;
    let item = button.closest('.item');
    let titulo = item.getElementsByClassName('titulo-item')[0].innerText;
    let precio = item.getElementsByClassName('precio-item')[0].innerText;
    let imagenSrc = item.getElementsByClassName('img-item')[0].src;
    let esServicio = item.getAttribute('data-es-servicio') === "true";

    agregarItemAlCarrito(titulo, precio, imagenSrc, esServicio, true);
}

// Agrega un item al carrito. `mostrarAlerta` distingue un click del usuario (true) de una carga desde LS (false)
function agregarItemAlCarrito(titulo, precio, imagenSrc, esServicio, mostrarAlerta) {
    let itemsCarrito = document.getElementsByClassName('carrito-items')[0];

    // Evitamos duplicados
    let nombresItemsCarrito = itemsCarrito.getElementsByClassName('carrito-item-titulo');
    for (let i = 0; i < nombresItemsCarrito.length; i++) {
        if (nombresItemsCarrito[i].innerText === titulo) {
            if (mostrarAlerta) {
                Swal.fire({
                    title: "El item ya se encuentra en el carrito",
                    icon: "warning",
                    confirmButtonText: "Aceptar"
                });
            }
            return;
        }
    }

    let item = document.createElement('div');
    item.classList.add('carrito-item');
    item.setAttribute('data-es-servicio', esServicio);
    item.innerHTML = `
        <img src="${imagenSrc}" alt="">
        <div class="carrito-item-detalles">
            <span class="carrito-item-titulo">${titulo}</span>
            <div class="selector-cantidad">
                <i class="fa-solid fa-minus restar-cantidad"></i>
                <input type="text" value="1" class="carrito-item-cantidad" disabled>
                <i class="fa-solid fa-plus sumar-cantidad"></i>
            </div>
            <span class="carrito-item-precio">${precio}</span>
        </div>
        <button class="btn-eliminar" title="Eliminar">
            <i class="fa-solid fa-trash"></i>
        </button>
    `;
    itemsCarrito.append(item);

    // Listeners del nuevo item
    item.getElementsByClassName('btn-eliminar')[0].addEventListener('click', eliminarItemCarrito);
    item.getElementsByClassName('restar-cantidad')[0].addEventListener('click', restarCantidad);
    item.getElementsByClassName('sumar-cantidad')[0].addEventListener('click', sumarCantidad);

    actualizarTotalCarrito();
    actualizarEstadoBotonesProductos();
    guardarCarritoEnLocalStorage();
}

// Aumenta en uno la cantidad del elemento seleccionado
function sumarCantidad(event) {
    let selector = event.target.closest('.selector-cantidad');
    let input = selector.getElementsByClassName('carrito-item-cantidad')[0];
    input.value = parseInt(input.value) + 1;
    actualizarTotalCarrito();
}

// Resta en uno la cantidad del elemento seleccionado
function restarCantidad(event) {
    let selector = event.target.closest('.selector-cantidad');
    let input = selector.getElementsByClassName('carrito-item-cantidad')[0];
    let cantidad = parseInt(input.value) - 1;
    if (cantidad >= 1) {
        input.value = cantidad;
        actualizarTotalCarrito();
    }
}

// Elimina el item seleccionado del carrito
function eliminarItemCarrito(event) {
    let item = event.target.closest('.carrito-item');
    if (item) item.remove();
    actualizarTotalCarrito();
    actualizarEstadoBotonesProductos();
    guardarCarritoEnLocalStorage();
}

// Actualiza el total del carrito
function actualizarTotalCarrito() {
    let carritoContenedor = document.getElementsByClassName('carrito')[0];
    let carritoItems = carritoContenedor.getElementsByClassName('carrito-item');
    let total = 0;
    for (let i = 0; i < carritoItems.length; i++) {
        let item = carritoItems[i];
        let precioElemento = item.getElementsByClassName('carrito-item-precio')[0];
        // Quitamos el símbolo peso, el punto de miles y sufijos como "/u"
        let precioTexto = precioElemento.innerText.replace('$', '').replace(/\./g, '').replace(/\/u.*/i, '').trim();
        let precio = parseFloat(precioTexto) || 0;
        let cantidad = parseInt(item.getElementsByClassName('carrito-item-cantidad')[0].value) || 1;
        total = total + (precio * cantidad);
    }
    total = Math.round(total * 100) / 100;
    document.getElementsByClassName('carrito-precio-total')[0].innerText = '$' + total.toLocaleString("es") + ",00";
}

// Sincroniza el estado de los botones de producto según si están o no en el carrito
function actualizarEstadoBotonesProductos() {
    let itemsCarrito = document.getElementsByClassName('carrito-items')[0];
    let titulosEnCarrito = [];
    if (itemsCarrito) {
        let elementos = itemsCarrito.getElementsByClassName('carrito-item-titulo');
        for (let i = 0; i < elementos.length; i++) {
            titulosEnCarrito.push(elementos[i].innerText.trim());
        }
    }

    let botones = document.getElementsByClassName('boton-item');
    for (let i = 0; i < botones.length; i++) {
        let boton = botones[i];
        let tarjeta = boton.closest('.item');
        if (!tarjeta) continue;
        let tituloEl = tarjeta.getElementsByClassName('titulo-item')[0];
        if (!tituloEl) continue;
        let titulo = tituloEl.innerText.trim();

        if (titulosEnCarrito.includes(titulo)) {
            boton.classList.add('boton-agregado');
            boton.innerHTML = 'Agregado <i class="fa-solid fa-check"></i>';
        } else {
            boton.classList.remove('boton-agregado');
            boton.innerHTML = 'Agregar al Carrito';
        }
    }
}
