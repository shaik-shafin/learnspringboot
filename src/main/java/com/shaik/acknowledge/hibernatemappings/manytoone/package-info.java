package com.shaik.acknowledge.hibernatemappings.manytoone;

/**
 * @author shaik shafin
 * @since 26-01-2025 6:00 PM
 *
 * -------------------------------------------------------------------------------------
 *                                  HIBERNATE MAPPINGS
 * -------------------------------------------------------------------------------------
 *
 * MANY TO ONE : UNI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Many to one means, one parent can have multiple children.
 * This is same as ONE TO MANY
 * but in this case we use @JoinColumn annotation on child table instead of parent table
 *
 * Hibernate:
 *     select
 *         s1_0.id,
 *         p1_0.id,
 *         p1_0.name,
 *         s1_0.student_name
 *     from
 *         student s1_0
 *     left join
 *         project p1_0
 *             on p1_0.id=s1_0.project_id
 *     where
 *         s1_0.id=?
 * Hibernate:
 *     select
 *         s1_0.project_id,
 *         s1_0.id,
 *         s1_0.student_name
 *     from
 *         student s1_0
 *     where
 *         s1_0.project_id=?
 *
 *
 * MANY TO ONE : BI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * This is exactly same as ONE TO MANY BI DIRECTIONAL
 *
 * Hibernate:
 *     select
 *         p1_0.id,
 *         p1_0.name
 *     from
 *         project p1_0
 *     where
 *         p1_0.id=?
 * Hibernate:
 *     select
 *         s1_0.project_id,
 *         s1_0.id,
 *         s1_0.student_name
 *     from
 *         student s1_0
 *     where
 *         s1_0.project_id=?
 */