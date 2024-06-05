using System.ComponentModel.DataAnnotations;

namespace TextInterpreterApi.Models
{
    public class Arquivo
    {
        [Key]
        [Required]
        public String URL { get; set; }

        public string nome { get; set; }


        public String tipo { get; set; }
    }
}
