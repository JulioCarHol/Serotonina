document.addEventListener('DOMContentLoaded', function () {
  let submitBtn = document.getElementById('submitBtn');

  submitBtn.addEventListener('click', function (event) {
    event.preventDefault();

    let question1 = document.querySelector('input[name="question1"]:checked');
    let question2 = document.querySelector('input[name="question2"]:checked');
    let question3 = document.querySelector('input[name="question3"]:checked');
    let question4 = document.querySelector('input[name="question4"]:checked');
    let question5 = document.querySelector('input[name="question5"]:checked');
    let question6 = document.querySelector('input[name="question6"]:checked');
    let question7 = document.querySelector('input[name="question7"]:checked');
    let question8 = document.querySelector('input[name="question8"]:checked');

    if (question1 && question2 && question3 && question4 && question5 && question6 && question7 && question8) {
      let score = parseInt(question1.value) + parseInt(question2.value) + parseInt(question3.value) + parseInt(question4.value) + parseInt(question5.value) + parseInt(question6.value) + parseInt(question7.value) + parseInt(question8.value);

      // Función para obtener el nivel de depresión y descripción correspondiente según la puntuación
      function getDepressionLevel(score) {
        let scale = [
          { score: 8, level: 'Minimalista', description: 'Tus niveles de depresión son muy bajos. Es posible que no experimentes síntomas depresivos significativos en tu vida cotidiana.', recommendation: 'Continúa manteniendo hábitos saludables para el bienestar emocional y busca actividades que te aporten sentido y satisfacción.' },
          { score: 16, level: 'Leve', description: 'Tus niveles de depresión son bajos. Puedes experimentar algunos síntomas depresivos de forma ocasional, pero no interfieren significativamente con tu funcionamiento.', recommendation: 'Sigue practicando el autocuidado: actividad física, descanso adecuado y conexión con seres queridos. Si te sientes abrumado/a, considera hablar con un profesional.' },
          { score: 24, level: 'Moderado', description: 'Tus niveles de depresión son moderados. Experimentas una cantidad significativa de síntomas depresivos que pueden afectar tu estado de ánimo y tu vida diaria.', recommendation: 'Es recomendable hablar con un profesional de la salud mental para obtener apoyo adicional y aprender estrategias de manejo del estado anímico.' },
          { score: 32, level: 'Alto', description: 'Tus niveles de depresión son altos. Los síntomas depresivos parecen estar presentes de manera significativa y pueden estar afectando tu funcionamiento diario.', recommendation: 'Te recomendamos buscar la ayuda de un profesional de la salud mental para obtener un diagnóstico y un plan de tratamiento adecuados.' },
          { score: 40, level: 'Muy alto', description: 'Tus niveles de depresión son muy altos. La depresión puede estar teniendo un impacto significativo en tu bienestar y funcionamiento diario.', recommendation: 'Te recomendamos buscar ayuda profesional lo antes posible. Un terapeuta o psiquiatra puede ayudarte a desarrollar estrategias de manejo y mejorar tu calidad de vida.' }
        ];

        for (let i = 0; i < scale.length; i++) {
          if (score <= scale[i].score) {
            return scale[i];
          }
        }
        return scale[scale.length - 1];
      }

      let depressionLevel = getDepressionLevel(score);

      // Muestra los resultados en el documento HTML
      let resultsSection = document.getElementById('results');
      resultsSection.innerHTML =
        '<h3>Resultados de la prueba</h3>' +
        '<p class="score">Puntuación: <strong>' + score + '</strong></p>' +
        '<p class="level">' + depressionLevel.level + '</p>' +
        '<p class="description">' + depressionLevel.description + '</p>' +
        '<p class="recommendation">' + depressionLevel.recommendation + '</p>';

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
