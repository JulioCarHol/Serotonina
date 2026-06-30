document.addEventListener('DOMContentLoaded', function () {
    let submitBtn = document.getElementById('submitBtn');

    submitBtn.addEventListener('click', function (event) {
        event.preventDefault();

        // Obtener respuestas seleccionadas (8 preguntas)
        let answers = [];
        let allAnswered = true;
        for (let i = 1; i <= 8; i++) {
            let answer = document.querySelector('input[name="question' + i + '"]:checked');
            if (!answer) {
                allAnswered = false;
                break;
            }
            answers.push(answer);
        }

        // Verificar que todas las preguntas estén respondidas
        if (allAnswered) {
            // Calcular puntuación (8 preguntas × valor 1–5 = rango 8–40)
            // En autoestima, score ALTO = mejor autoestima (los radios van 5→1: positivo→negativo)
            let score = answers.reduce((sum, a) => sum + parseInt(a.value), 0);

            // Función para obtener el nivel de autoestima según la puntuación
            function getSelfEsteemLevel(score) {
                let scale = [
                    { score: 8, level: 'Autoestima muy baja', description: 'Tus niveles de autoestima son muy bajos. Puedes sentirte inseguro/a y tener dificultades para valorarte a ti mismo/a.', recommendation: 'Te recomendamos buscar el apoyo de un profesional de la salud mental. Un terapeuta puede ayudarte a identificar fortalezas, trabajar la autocompasión y construir una autoimagen más positiva.' },
                    { score: 16, level: 'Autoestima baja', description: 'Tus niveles de autoestima son bajos. Puedes tener momentos de duda y sentirte crítico/a contigo mismo/a.', recommendation: 'Considera practicar la autocompasión y reconocer tus logros, por pequeños que sean. Hablar con un profesional puede ayudarte a desarrollar una visión más amable de ti mismo/a.' },
                    { score: 24, level: 'Autoestima moderada', description: 'Tus niveles de autoestima son moderados. En general, tienes una opinión equilibrada de ti mismo/a, pero aún puedes mejorar.', recommendation: 'Sigue cultivando el autocuidado y reconoce tus fortalezas. Actividades como escribir un diario de gratitud o fijarte metas realistas pueden fortalecer tu autoestima.' },
                    { score: 32, level: 'Autoestima alta', description: 'Tus niveles de autoestima son altos. Te valoras y tienes confianza en tus habilidades y capacidades.', recommendation: 'Continúa practicando el autocuidado y manteniendo relaciones sanas que refuercen tu bienestar. Tu base sólida es un gran recurso para afrontar nuevos desafíos.' },
                    { score: 40, level: 'Autoestima muy alta', description: 'Tus niveles de autoestima son muy altos. Te sientes seguro/a y satisfecho/a contigo mismo/a en la mayoría de las situaciones.', recommendation: 'Excelente. Sigue aplicando tus estrategias de autocuidado y considera compartir tu experiencia para apoyar a quienes están construyendo su propia autoestima.' }
                ];

                for (let i = 0; i < scale.length; i++) {
                    if (score <= scale[i].score) {
                        return scale[i];
                    }
                }
                return scale[scale.length - 1];
            }

            let selfEsteemLevel = getSelfEsteemLevel(score);

            // Muestra los resultados en el documento HTML
            let resultsSection = document.getElementById('results');
            resultsSection.innerHTML =
                '<h3>Resultados de la prueba</h3>' +
                '<p class="score">Puntuación: <strong>' + score + '</strong></p>' +
                '<p class="level">' + selfEsteemLevel.level + '</p>' +
                '<p class="description">' + selfEsteemLevel.description + '</p>' +
                '<p class="recommendation">' + selfEsteemLevel.recommendation + '</p>';

            // Restablece las respuestas seleccionadas
            document.querySelector('form').reset();

            // Animación de desplazamiento suave hacia la sección de resultados
            resultsSection.scrollIntoView({ behavior: 'smooth' });

        } else {
            // Mostrar alerta con SweetAlert
            Swal.fire({
                icon: 'warning',
                title: 'Respuestas incompletas',
                text: 'Por favor, responde todas las preguntas antes de enviar la prueba.',
            });
        }
    });
});
