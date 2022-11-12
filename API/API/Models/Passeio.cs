using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Passeio")]
    public class Viagem
    {
        [Key]
        public int id { get; set; }

        [Required(ErrorMessage = "Informe a origem da viagem")]
        [StringLength(50)]
        public string Origem { get; set; }

        [Required(ErrorMessage = "Informe a data da Ida da viagem")]
        [StringLength(10)]
        public string DataOrigem { get; set; }

        [Required(ErrorMessage = "Informe o destino da viagem")]
        [StringLength(50)]
        public string Destino { get; set; }

        [Required(ErrorMessage = "Informe a data de Volta da viagem")]
        [StringLength(10)]
        public string DataDestino { get; set; }
    }
}
