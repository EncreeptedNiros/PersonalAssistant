using System.ComponentModel.DataAnnotations;

namespace TextInterpreterApi.Models
{
    public class Agenda
    {
        [Key]
        [Required]
        public int Id { get; set; }
        [Required]
        public string task { get; set; }

        [Required]
        public DateTime taskdate { get; set; }
    }
}