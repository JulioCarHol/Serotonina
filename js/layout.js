document.addEventListener('DOMContentLoaded', () => {
  // ---- Toggle del menú móvil + morph hamburguesa → X ----
  const menuHamburger = document.querySelector('.menu-hamburger');
  const navLinks = document.querySelector('.nav-links');
  if (menuHamburger && navLinks) {
    menuHamburger.addEventListener('click', () => {
      const open = navLinks.classList.toggle('mobile-menu');
      menuHamburger.classList.toggle('fa-bars', !open);
      menuHamburger.classList.toggle('fa-xmark', open);
    });
  }

  // ---- Resaltar el enlace de la página actual ----
  const here = (location.pathname.split('/').pop() || 'index.html').toLowerCase();
  document.querySelectorAll('.navbar .nav-links a:not(.carro)').forEach((a) => {
    const href = (a.getAttribute('href') || '').split('/').pop().toLowerCase();
    if (href && href === here) a.classList.add('active');
  });
});
