using System.ComponentModel.DataAnnotations;

namespace TextInterpreterApi.Models
{
    public class Interpretation
    {
        [Key]
        [Required]
        public int Id { get; set; }
        [Required]
        public string text { get; set; }

        [Required]
        public DateTime saytime { get; set; }
    }
}
