﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using TextInterpreterApi.Data;

#nullable disable

namespace TextInterpreterApi.Migrations
{
    [DbContext(typeof(AgendaContext))]
    [Migration("20231207090745_1Agenda")]
    partial class _1Agenda
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.11")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("TextInterpreterApi.Models.Agenda", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("task")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<DateTime>("taskdate")
                        .HasColumnType("datetime(6)");

                    b.HasKey("Id");

                    b.ToTable("Agendas");
                });
#pragma warning restore 612, 618
        }
    }
}
